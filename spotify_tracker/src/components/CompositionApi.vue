<script setup>
import { reactive } from 'vue';

const state = reactive({
  login: 'johndoe',
      name: 'John Doe',
      bio: '...',
      company: 'Acme Inc.',
      avatar_url: 'https://unsplash.it/256',
      repos: [],
      searchInput: ''
})

async function fetchGithubUser() {
      const res = await fetch(`https://api.github.com/users/${state.searchInput}`)
      const { login, name, bio, company, avatar_url } = await res.json()

      state.login = login
      state.name = name
      state.bio = bio
      state.company = company
      state.avatar_url = avatar_url
      state.repos = []

      fetchUserRepositories(login)
}

async function fetchUserRepositories() {
  const res = await fetch(`https://api.github.com/users/${state.login}/repos`)
  const repos = await res.json()
  state.repos = repos
}

</script>


<template>
  	<h1>GitHub User Data</h1>
  <input type="text" v-model="state.searchInput">
  <button v-on:click="fetchGithubUser">Carregar Usuário</button>
  <div v-if="state.login !== ''">
    <img v-bind:src="state.avatar_url">
    <strong>@{{ state.login }}</strong>
    <h2>{{ state.name }}</h2>
    <h3>{{ state.company }}</h3>
    <span>{{ state.bio }}</span>  
  

  <article v-for="repo of state.repos"> 
    <h3>{{ repo.full_name }}</h3>
    <p>{{ repo.description }}</p>
    <a :href="repo.html_url" target="_blank">ver no GitHub</a>
  </article>
</div>


</template>