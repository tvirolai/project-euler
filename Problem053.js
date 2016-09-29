'use strict';

const math = require('mathjs');

const LIMIT = 1000000;
let count = 0;

function combinations(n, r) {
  return math.factorial(n) / (math.factorial(r) * (math.factorial(n-r)));
}

for (let n = 23; n <= 100; n++) {
  for (let r = 1; r <= n; r++) {
    let comb = combinations(n, r);
    if (comb > LIMIT) {
      count++; 
    }
  }
}

console.log(`Problem 52: ${count}`);
