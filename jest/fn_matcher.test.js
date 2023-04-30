const fn = require('./fn');


/*
toBe
 */
test('1은 1이야', () => {
    expect(1).toBe(1);
});

test('2 더하기 3은 5야', () => {
   expect(fn.add(2, 3)).toBe(5);
});

test('3 더하기 3은 5가 아니야', () => {
    expect(fn.add(3, 3)).not.toBe(5);
});



/*
toEqual,
toStrictEqual
 */
//객체는 내부 프로퍼티의 비교를 위해, 깊은비교 toEqual로 사용해야함
test('이름과 나이를 전달받아서 객체를 반환해줘', () => {
    expect(fn.makeUser('mike', 30)).toEqual({ name: 'mike', age: 30 });
});

//toStrictEqual은 좀더 엄격하게 객체의 모든 프로퍼티를 하나하나 꼼꼼히 검사한다
test('이름과 나이를 전달받아서 객체를 반환해줘(strict)', () => {
    expect(fn.makeUser('mike', 30)).toStrictEqual({ name: 'mike', age: 30, gender: undefined });
});



/*
toBeNull,
toBeUndefined
toBeDefined
 */
test('null은 null입니다', () => {
    expect(null).toBeNull();
});



/*
toBeTruthy
toBeFalsy
 */
test('0은 falsy값 입니다', () => {
    expect(fn.add(1, -1)).toBeFalsy();
});

test('문자열 add', () => {
    expect(fn.add('hello world')).toBeTruthy();
});



/*
toBeGraterThan 크다
toBeGraterThanOrEqual 크거나 같다
toBeLessThan 작다
toBeLessThanOrEqual 작거나 같다
 */
test('id는 10자 이하여야 합니다', () => {
    const id = '나는 10글자 이하';
    expect(id.length).toBeLessThanOrEqual(10);
});

test('0.1 더하기 0.2는 0.3이 아닙니다(부동소수점)', () => {
    expect(fn.add(0.1, 0.2)).not.toBe(0.3);
});

test('0.1 더하기 0.2는 0.3과 근사한 값입니다(부동소수점)', () => {
    expect(fn.add(0.1, 0.2)).toBeCloseTo(0.3);
});

test('Hello World 에 a,A 라는 글자는 없다', () => {
    expect("Hello World").not.toMatch(/a/i);
});



/*
toContain
 */
test('유저 리스트에 Mike는 있지만 Bruno는 없다', () => {
    const user1 = 'Mike';
    const user2 = 'Bruno';
    const userList = ['Tom', 'Jane', 'Kai', 'Mike'];
    expect(userList).toContain(user1);
    expect(userList).not.toContain(user2);
});


/*
toThrow
 */
test('어떤 에러든 발생했나요?', () => {
    expect(() => {
        fn.throwError().toThrow();
    });
});

test(' "고의 에러" 타입의 에러가 발생했나요?', () => {
    expect(() => {
        fn.throwError().toThrow('고의 에러');
    })
});