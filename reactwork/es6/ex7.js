let array = ['red', 'green', 'blue', 'pink'];
array.map((num, idx) => (console.log(idx + ":" + num)));

// blue 삭제 후 재출력
console.log("\n");
array = [
    ...array.slice(0, 2), /* red, green만(0~1) 펼침 */
    ...array.slice(3, array.length) /* 3번 ~ 끝까지 펼침 */
];
array.map((num, idx) => (console.log(idx + ":" + num)));

let array2 = ['red', 'green', 'blue', 'pink'];
// 2번만 제외하고 출력
console.log("\n");
array2 = array2.filter((item, i) => i!==2); // i가 2가 아닌 것만 필터링(반환)
array2.map((num, idx) => (console.log(idx + ":" + num)));

console.log(Number('01')); // 숫자로 변환
