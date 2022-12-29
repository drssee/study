//불변객체

//Object.freeze()로 동결을 해도
//내부 객체는 동결이 되지 않음
const person = {
    name: 'Lee',
    address: {
        city: 'Seoul'
    }
};

//얕은 객체 동결
Object.freeze(person);

//중첩객체는 동결하지 못한다
Object.isFrozen(person.address);//false

//그러므로 city의 프로퍼티 어트리뷰트가 writable: true이고
//값이 변경 될 수 있음
person.address.city = 'Busan';
console.log(person.address.city);//Busan
