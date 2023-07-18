package sort.heap;

import java.util.PriorityQueue;

/**
 * 최소 힙 : 부모 노드의 값(key 값) ≤ 자식 노드의 값(key 값)
 * 최대 힙 : 부모 노드의 값(key 값) ≥ 자식 노드의 값(key 값)
 *
 * 힙 구현 -> 배열 (효율적)
 * 연결 리스트도 가능하지만, 노드의 검색, 이동 과정이 번거롭다.
 *
 * 절대 불변의 3법칙
 * 1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
 * 2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
 * 3. 부모 노드 인덱스 = (자식 노드 인덱스 - 1) / 2
 *
 * 힙 -> 부모노드와 자식노드보다 우선순위가 높다.
 * 이는 형제노드와는 정렬이 되지않은 상태라, 반 정렬 상태가 된다.
 */


class Priority{
    /**
     * PriorityQueue<>()를 활용한 정렬
     *
     * heap을 위한 별도의 공간을 만들기 때문에 메모리가 비효율적
     */
    public static void test(){
        System.out.println("PriorityQueue 자료구조를 활용한 정렬");
        int[] arr = {3, 7, 5, 4, 2, 8};
        System.out.print(" 정렬 전 original 배열 : ");
        for (int val : arr) {
            System.out.print(val + " ");
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }

        System.out.print("\n 정렬 후 sortedArr 배열: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("\n");
    }
}

/**
 * 메모리 비효율 사용등의 이유로 직접 구현하는 Heap 정렬
 * 그렇지만 아직 이해하지 못했음
 * 후에 천천히 이해해볼 예정 및 관련 링크 (https://st-lab.tistory.com/225)
 */
class ArrayHeapSort{
    public static void sort(int[] a) {
        sort(a, a.length);
    }

    private static void sort(int[] a, int size) {

        /*
         * 부모노드와 heaify과정에서 음수가 발생하면 잘못 된 참조가 발생하기 때문에
         * 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없으므로 바로 함수를 종료한다.
         */
        if(size < 2) {
            return;
        }

        /*
         * left child node = index * 2 + 1
         * right child node = index * 2 + 2
         * parent node = (index - 1) / 2
         */

        // 가장 마지막 요소의 부모 인덱스
        int parentIdx = getParent(size - 1);

        // max heap
        for(int i = parentIdx; i >= 0; i--) {
            heapify(a, i, size - 1);
        }


        for(int i = size - 1; i > 0; i--) {

            /*
             *  root인 0번째 인덱스와 i번째 인덱스의 값을 교환해준 뒤
             *  0 ~ (i-1) 까지의 부분트리에 대해 max heap을 만족하도록
             *  재구성한다.
             */
            swap(a, 0, i);
            heapify(a, 0, i - 1);
        }

    }


    // 부모 인덱스를 얻는 함수
    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    // 두 인덱스의 원소를 교환하는 함수
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    private static void heapify(int[] a, int parentIdx, int lastIdx) {

        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        /*
         * 현재 부모 인덱스의 자식 노드 인덱스가
         * 마지막 인덱스를 넘지 않을 때 까지 반복한다.
         *
         * 이 때 왼쪽 자식 노드를 기준으로 해야 한다.
         * 오른쪽 자식 노드를 기준으로 범위를 검사하게 되면
         * 마지막 부모 인덱스가 왼쪽 자식만 갖고 있을 경우
         * 왼쪽 자식노드와는 비교 및 교환을 할 수 없기 때문이다.
         */
        while((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            /*
             * left child node와 비교
             * (범위는 while문에서 검사했으므로 별도 검사 필요 없음)
             */
            if (a[leftChildIdx] > a[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            /*
             * right child node와 비교
             * right child node는 범위를 검사해주어야한다.
             */
            if (rightChildIdx <= lastIdx && a[rightChildIdx] > a[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            /*
             * 교환이 발생했을 경우 두 원소를 교체 한 후
             * 교환이 된 자식노드를 부모 노드가 되도록 교체한다.
             */
            if (largestIdx != parentIdx) {
                swap(a, parentIdx, largestIdx);
                parentIdx = largestIdx;
            }
            else {
                return;
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Priority.test();
        System.out.println("Array 하나만 사용하는 Heap 정렬");
        int[] arr = new int[]{3, 7, 5, 4, 2, 8};
        System.out.print(" 정렬 전 original 배열 : ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        ArrayHeapSort.sort(arr);
        System.out.print("\n 정렬 후 sortedArr 배열: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("\n");
    }
}
