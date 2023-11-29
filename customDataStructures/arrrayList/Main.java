package Java.OOPS.customDataStructures.arrrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(87);
        list.add(54);
        System.out.println(list.toString());
        list.remove();
        System.out.println(list.toString());
        list.add(98);
        System.out.println(list.toString());
        list.erase();
        System.out.println(list.toString());
        System.out.println(list.size());
    }
}
