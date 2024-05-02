package org.example.ForkJoinPool;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample extends RecursiveTask<Integer> {

    int start;
    int end;
    RecursiveTaskExample(int start, int end){
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args){
        RecursiveTaskExample recursiveTaskExample = new RecursiveTaskExample(1,10);
        System.out.println(recursiveTaskExample.compute());
    }
    @Override
    protected Integer compute() {
        if (end-start<=4){
            int totalSum = 0;
            for (int i=start; i<=end; i++){
                totalSum += i;
            }
            return totalSum;
        } else {
            // split the task
            int mid = (start+end)/2;
            RecursiveTaskExample leftTask = new RecursiveTaskExample(start,mid);
            RecursiveTaskExample rightTask = new RecursiveTaskExample(mid+1,end);

            // Fork the subtasks for parallel execution
            leftTask.fork();
            rightTask.fork();

            // Combine the results of subtasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // final answer
            return leftResult+rightResult;
        }
    }
}