## Bubble sort

 - How to run **Bubble sort** applet:
 
   ```
   appletviewer http://cs.brynmawr.edu/Courses/cs206/spring2004/WorkshopApplets/Chap03/Bubble/BubbleSort.html
   ```
   
В ходе работы пузырьковой сортировки самый большой элемент, словно пузырек в жидкости, всплывает до конца массива   
   
Сортировка выполняется по следующим правилам:
1. Сравнить два элемента массива.
2. Если левый элемент больше, поменять их местами.
3. Перейти на одну позицию вправо   

Перестановки продолжаются до тех пор, пока не будет достигнут конец массива

4. После того как первый отсортированный элемент окажется на своем месте,
вернуться к началу массива

```java
public void sort() {
    for (int i = 0; i < array.length; i++) {
        for(int j = i + 1; j < array.length; j++){
            if(array[i] > array[j]){
                swap(i, j);
            }
        }
    }
}
```
   
### Сложность пузырьковой сортировки   

`Пузырьковая сортировка выполняется за время O(N2)`