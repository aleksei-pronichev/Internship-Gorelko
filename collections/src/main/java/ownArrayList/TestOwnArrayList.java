package ownArrayList;

public class TestOwnArrayList {

    public static void main(String[] args) {

        OwnArrayList<String> ownArray = new OwnArrayList<>();

        ownArray.add("Text1");
        ownArray.add("Text2");
        ownArray.add("Text3");
        ownArray.add("Text4");
        ownArray.add("Text5");
        ownArray.add("Text1");
        ownArray.add("Text2");
        ownArray.add("Text3");
        ownArray.add("Text4");
        ownArray.add("Text5");

        ownArray.update(2, "Update");
        System.out.print("\nВывод массива после замены элемента: ");
        ownArray.printOwnArray();

        ownArray.delete(9);
        System.out.print("\nВывод массива после удаления элемента: ");
        ownArray.printOwnArray();

        ownArray.add("Text3");
        System.out.print("\nВывод массива после вставки элемента: ");
        ownArray.printOwnArray();

        System.out.print("\nВывод элемента под индексом '0': " + ownArray.get(0));
        System.out.print("\nВывод размера массива: " + ownArray.size());

    }

}
