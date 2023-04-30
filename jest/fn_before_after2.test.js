const fn = require('./fn');

let user;


/*
describe
 */
describe('user 관련 작업', () => {
    /*
    junit에서 모든 테스트 전후로 한번씩 실행되는 메서드와 같음
    */
    beforeAll(async () => {
        user = await fn.connectUserDb();
    });

    afterAll(() => {
        return fn.disconnectUserDb();
    });

    test('이름은 Mike', () => {
        expect(user.name).toBe('Mike');
    });

    test('나이는 30', () => {
        expect(user.age).toBe(30);
    });

    test('성별은 남성', () => {
        expect(user.gender).toBe('male');
    });
});

describe('car 관련 작업', () => {
    /*
    junit에서 모든 테스트 전후로 한번씩 실행되는 메서드와 같음
    */
    beforeAll(async () => {
        car = await fn.connectCarDb();
    });

    afterAll(() => {
        return fn.disconnectCarDb();
    });

    test('브랜드는 bmw', () => {
        expect(car.brand).toBe('bmw');
    });

    test('이름은 z4', () => {
        expect(car.name).toBe('z4');
    });

    test('색깔은 red', () => {
        expect(car.color).toBe('red');
    });
});


