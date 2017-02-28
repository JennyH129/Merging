# Merging
## Methodology
We tested our merge sort algorithm on arrays of size 1, 10, 100, 1000, and 10000, as well as sizes in between, and compared the average time that it took each array to be sorted. Because the average time to sort an array of size 1 was so low, we ran the merge sort algorithm on each array 10000 times, and then divided that time by 10000 to find the average time. In addition, the arrays that are being sorted are randomly generated, but this should not have an effect on the run time of merge sort because it is not dependent on the preexisting order of the array. After we ran the tester program, we collected the data and plotted a line graph of the results. 

##Findings
We've concluded the runtime is closest to n * log n.
Here are the results of the tests and a graph representing our data: https://docs.google.com/spreadsheets/d/13v5srXe7uQezPFvbrPu5IX-vzUuQdH5xo9lCknSLXdA/edit?usp=sharing
