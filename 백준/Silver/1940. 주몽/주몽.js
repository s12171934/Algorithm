const { count } = require('console');
const fs = require('fs');
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split('\n');
const testCase = {
  N : input[0],
  M : input[1],
  arr : input[2].split(' ').sort((n1, n2) => (n1 - n2)),
}

const solution = (testCase) => {
  let count = 0;
  let minP = 0;
  let maxP = testCase.N - 1;
  const arr = testCase.arr;

  while (minP < maxP) {
    const sum = Number(arr[minP]) + Number(arr[maxP]);
    if (sum == testCase.M) {
      count++;
      minP++;
      maxP--;
    }
    else if (sum < testCase.M) {
      minP++;
    }
    else {
      maxP--;
    }
  }

  return count;
}

console.log(solution(testCase));