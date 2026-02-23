public class Elevador {
    private int andarAtual;
    private int total_Andares;
    private int capacidade;
    private int quantidadePessoas;

    //METODO
    public void inicializa(int capacidade, int total_Andares){
        this.total_Andares = total_Andares;
        this.capacidade = capacidade;
        this.andarAtual = 0;
        this.quantidadePessoas = 0;
    }

    public void entrar() {
        if(this.capacidade > this.quantidadePessoas){
            this.quantidadePessoas ++;
            System.out.println(" Entrou uma pessoa no elevador.");
        } else {
            System.out.println( " O elevador já está cheio.");
        }
    }

    public void sai() {
        if(this.quantidadePessoas>0){
            this.quantidadePessoas--;
            System.out.println(" Saiu uma pessoa do elevador.");
        }
    }

    public void subir() {
        if(this.andarAtual<this.total_Andares){
            this.andarAtual++;
            System.out.println(" O elevador subiu 1 andar.");
        } else {
            System.out.println(" Já está no ultimo andar. ");
        }
    }

    public void descer() {
        if(this.andarAtual>0){
            this.andarAtual--;
            System.out.println(" O elevador desceu 1 andar.");
        } else {
            System.out.println(" O elevador não pode mais descer pois está no térreo.");
        }
    }

    public String status() {
        return "Andar atual = " + this.andarAtual + "\nNumero de pessoas no elevador = " + this.quantidadePessoas + " \nCapacidade = " + this.capacidade;
    }
    
}
