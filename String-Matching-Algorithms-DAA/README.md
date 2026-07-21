# Comparative Analysis of Naive, Rabin-Karp, and KMP Algorithms for String Matching

## Experiment No: 2

### Aim
To implement and compare the performance of Naive, Rabin-Karp, and Knuth-Morris-Pratt (KMP) algorithms for string pattern matching.

---

## Objective
The objective of this experiment is to study different string matching algorithms and compare their efficiency in finding a pattern within a given text.

---

## Programs Included
- Naive.java
- RabinKarp.java
- KMP.java

---

## Software Requirements
- Java JDK 21 (or above)
- Visual Studio Code
- Git
- GitHub

---

## Algorithms

### 1. Naive String Matching
- Compares the pattern with the text character by character.
- Shifts the pattern one position at a time.

### 2. Rabin-Karp Algorithm
- Uses hashing to compare the pattern with the text.
- Reduces unnecessary character comparisons.

### 3. KMP (Knuth-Morris-Pratt) Algorithm
- Uses the Longest Prefix Suffix (LPS) array.
- Avoids redundant comparisons, making it more efficient.

---

## Time Complexity

| Algorithm | Best Case | Average Case | Worst Case |
|-----------|-----------|--------------|------------|
| Naive | O(n) | O(nm) | O(nm) |
| Rabin-Karp | O(n+m) | O(n+m) | O(nm) |
| KMP | O(n+m) | O(n+m) | O(n+m) |

---

## Sample Input

Text:
```
ABABDABACDABABCABAB
```

Pattern:
```
ABABCABAB
```

---

## Sample Output

```
Pattern found at index 10
```

---

## Repository Structure

```
String-Matching-Algorithms-DAA
│── Naive.java
│── RabinKarp.java
│── KMP.java
└── README.md
```

---

## Conclusion

The Naive algorithm is simple but less efficient for large texts. Rabin-Karp improves performance using hashing but may experience hash collisions. KMP is the most efficient among the three because it uses the LPS array to avoid unnecessary comparisons, resulting in linear time complexity in the worst case.

---

## Author

**Ashin D**