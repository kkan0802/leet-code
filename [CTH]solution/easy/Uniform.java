package programmers;

import java.util.ArrayList;
import java.util.List;

class Student {
    private boolean lost;
    private boolean reserve;

    public boolean isLost() {
        return lost;
    }

    public boolean isNotLost() {
        return !isLost();
    }

    public boolean isReserve() {
        return reserve;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public void borrow(Student o) {
        o.setReserve(false);
        this.setLost(false);
    }
}

public class Uniform {
    public static int solution(int n, int[] lost, int[] reserve) {

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            students.add(student);
        }

        for (int i = 0; i < lost.length; i++) {
            students.get(lost[i] - 1).setLost(true);
        }

        for (int i = 0; i < reserve.length; i++) {
            students.get(reserve[i] - 1).setReserve(true);
        }

        for (int i = 0; i < students.size() - 1; i++) {
            Student front = students.get(i);
            Student back = students.get(i + 1);
            
            if (front.isReserve() && front.isLost()) {
                front.setReserve(false);
                front.setLost(false);
            } else if (back.isReserve() && back.isLost()) {
                back.setReserve(false);
                back.setLost(false);
            } else if (front.isReserve() && back.isLost()) {
                back.borrow(front);
            } else if (back.isReserve() && front.isLost()) {
                front.borrow(back);
            }
        }

        return (int) students.stream().filter(Student::isNotLost).count();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }
}
