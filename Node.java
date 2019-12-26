public class Node {
    public String key;
    public String value;


    public Node (String key, String value) {
        this.key = key;
        this.value = value;
    }



    public String key(){
        return this.key;
    }

    public void key (String key){
        this.key = key;
    }


    public void value(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }


    public String keyHash(int count){
        return this.key.hashCode();
    }

    


}