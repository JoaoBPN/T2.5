public class Sequenciador {
    private Integer id;

    public Sequenciador(){
        this.id = 0;
    }

    public Integer getNewId(){
        id++;
        return id;
    }

}
