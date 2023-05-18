package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0; // số phần tử trong danh sách
    private static final int DEFAULT_CAPACITY = 10; // dung lượng mặc định của danh sách
    private Object elements[]; // mảng chứa các phần tử của danh sách

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    //Thêm phần tử
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1); // đảm bảo dung lượng đủ cho danh sách
        System.arraycopy(elements, index, elements, index + 1, size - index); // dịch chuyển các phần tử sang phía sau để tạo chỗ cho phần tử mới
        elements[index] = element; // thêm phần tử mới vào danh sách
        size++; // tăng số phần tử trong danh sách
    }

    //Xóa phần tử
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) elements[index]; // lưu trữ phần tử bị xóa
        System.arraycopy(elements, index + 1, elements, index, size - index - 1); // dịch chuyển các phần tử sang phía trước để xóa phần tử
        size--; // giảm số phần tử trong danh sách
        elements[size] = null; // giải phóng vùng nhớ của phần tử cuối cùng
        return removedElement; // trả về phần tử bị xóa
    }

    public int size() {
        return size;
    }
    public Object clone() {
        try {
//            MyList<E> clonedList = (MyList<E>) super.clone(); // sao chép đối tượng MyList
            MyList<E> clonedList = new MyList<>(); // sao chép đối tượng MyList
            clonedList.elements = Arrays.copyOf(elements, size); // sao chép mảng elements
            return clonedList;
        } catch (IndexOutOfBoundsException e) {
            throw new InternalError(e);
        }
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean add(E o) {
        ensureCapacity(size + 1); // đảm bảo dung lượng đủ cho danh sách
        elements[size] = o; // thêm phần tử mới vào danh sách
        size++; // tăng số phần tử trong danh sách
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2; // tăng dung lượng lên gấp đôi
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity); // tạo mảng mới có dung lượng mới và sao chép các phần tử từ mảng cũ sang mảng mới
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null; // giải phóng vùng nhớ của từng phần tử trong danh sách
        }
        size = 0; // đặt số phần tử về 0
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}