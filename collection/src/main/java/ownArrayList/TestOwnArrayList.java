package ownArrayList;

public class TestOwnArrayList {

    public static void main(String[] args) {

        OwnArrayList<String> ownArray = new OwnArrayList<>();

        ownArray.add("Text1");
        ownArray.add("Text2");
        ownArray.add("Text3");
        ownArray.add("Text4");
        ownArray.add("Text5");

        System.out.print("Вывод всего массива: ");
        for (String s : ownArray) {
            System.out.print(s + " ");
        }

        ownArray.update(2, "Update");
        System.out.print("\nВывод массива после замены элемента: ");
        for (String s : ownArray) {
            System.out.print(s + " ");
        }

        ownArray.delete(2);
        System.out.print("\nВывод массива после удаления элемента: ");
        for (String s : ownArray) {
            System.out.print(s + " ");
        }

        ownArray.add("Text3");
        System.out.print("\nВывод массива после вставки элемента: ");
        for (String s : ownArray) {
            System.out.print(s + " ");
        }

        System.out.print("\nВывод элемента под индексом '0': " + ownArray.get(0));
        System.out.print("\nВывод размера массива: " + ownArray.size());

    }
}
