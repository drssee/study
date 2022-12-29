//객체동결(get)

const person = {name:'Lee'};

Object.freeze(person);

console.log(Object.isFrozen(person));//true

//동결된 객체의 프로퍼티의 프로퍼티 어트리뷰트는 writable과 configurable이 false다
let descriptors = Object.getOwnPropertyDescriptors(person);
console.log(descriptors);

//무시됨
person.age = 20;
delete person.name;
person.name = 'Kim';
//오류발생
Object.defineProperty(person,'name',{
    configurable: true
});


