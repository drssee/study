const fn = require('./fn');

let num = 0;
let sum = 0;

/*
junit과 동일하게 beforeEach 사용 가능
 */
beforeEach(() => {
    num = 0;
});

afterEach(() => {
    sum += num;
    console.log(sum);
})

test('case1', () => {
    num = fn.add(num, 1);
    expect(num).toBe(1);
});

test('case2', () => {
    num = fn.add(num, 1);
    expect(num).toBe(1);
});

test('case3', () => {
    num = fn.add(num, 1);
    expect(num).toBe(1);
});