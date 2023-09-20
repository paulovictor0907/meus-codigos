public class Partida {
    private static int QtdPeriodo = 4;
	private Time Timelocal;
	private Time TimeVIsitante;
	private String Local;
	private int PontoEquipeLocal;
	private int PontoEquipeVisitante;

    public Partida(Time timeLocal, Time timeVisitante, String Local){
        this.Timelocal = timeLocal;
        this.TimeVIsitante = timeVisitante;
        this.Local = Local;

    }

    public boolean verificaGanhador(){
        return PontoEquipeLocal > PontoEquipeVisitante;

    }

    public String timeVencedor(){
        if(PontoEquipeLocal > PontoEquipeVisitante){
            return timeLocal.getNome();
        } else if (PontoEquipeLocal < PontoEquipeVisitante){
            return timeVIsitante.getNome();
        }else{
            return "EMPATE";
        }

    }

    public void geraProrrogacao(){
        QtdPeriodo++;

    }

    public void ImprimePlacarAtual(){
        System.out.println("Placar atual da partida em " + Local + ":");
        System.out.println(timeLocal.getNome() + " " + PontoEquipeLocal + " - " + PontoEquipeVisitante + " " + timeVisitante.getNome());

    }
    
}
