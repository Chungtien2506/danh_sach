package arraylist;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        // Thêm phần tử vào danh sách
        for (int i = 0; i < 15; i++) {
            myList.add(i);
        }

        // In danh sách ban đầu
        System.out.println("Danh sách ban đầu:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        // Thêm phần tử vào vị trí 5
        myList.add(5, 99);
        System.out.println("Danh sách sau khi thêm phần tử vào vị trí 5:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        // Xóa phần tử ở vị trí 8
        myList.remove(8);
        System.out.println("Danh sách sau khi xóa phần tử ở vị trí 8:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        // Sao chép danh sách và in ra
        MyList<Integer> clonedList = (MyList<Integer>) myList.clone();
        System.out.println("Danh sách đã sao chép:");
        System.out.println(clonedList);
        System.out.println();

        // Kiểm tra xem phần tử 99 có tồn tại trong danh sách không
        System.out.println("Danh sách có chứa phần tử 99 không? " + myList.contains(99));

        // Tìm vị trí đầu tiên của phần tử 5 trong danh sách
        System.out.println("Vị trí đầu tiên của phần tử 5 trong danh sách là: " + myList.indexOf(5));

        // Tìm vị trí của phần tử không tồn tại trong danh sách
        System.out.println("Vị trí của phần tử không tồn tại trong danh sách là: " + myList.indexOf(100));

        // Thêm phần tử mới vào cuối danh sách
        myList.add(555);
        System.out.println("Danh sách sau khi thêm phần tử mới vào cuối danh sách:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        // Xóa tất cả phần tử trong danh sách
        myList.clear();
        System.out.println("Danh sách sau khi xóa tất cả phần tử:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }
}
