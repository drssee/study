const fn = require('./fn');

/*
비동기 함수 테스트 (done 콜백 전달)
 */
test('3초후에 받아온 이름은 Mike야', (done) => {
    function callback(name) {
        expect(name).toBe('Mike');
        done();
    }
    fn.getName(callback);
});

//프로미스의 경우
//done은 없어도 되지만, 프로미스를 return 해줘야함
test('3초후에 받아온 나이는 30이야', () => {
    return fn.getAge().then(res => {
        expect(res).toBe(30);
    });
});

//성공일 경우(resolve)
test('3초후에 받아온 나이는 30이야(다른 버전)', () => {
    return expect(fn.getAge('성공')).resolves.toBe(30);
});

//실패일 경우(reject)
test('3초후에 에러가 납니다', () => {
    return expect(fn.getAge('실패')).rejects.toEqual(new Error('고의 에러'));
});

//async await 적용
test('3초후에 받아온 나이는 30이야(async await 적용)', async () => {

    //프로미스를 리턴하는 함수 앞에 await가 붙으면,
    //해당 함수가 리턴하는것은 프로미스 객체가 아닌 , resolve()안의 파라미터 값인 30이다
    const age = await fn.getAge('성공');

    console.log(typeof age);
    return expect(age).toBe(30);
});



