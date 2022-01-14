package ownLinkedList;

public class Test {
    public static void main(String[] args) {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen1");
        ownList.add("Andersen2");
        ownList.add("Andersen3");
        ownList.add("Andersen4");

        for (String text : ownList){
            System.out.println(text);
        }
    }
}
