//객체 밀봉(get set)
const person = {name:'Lee'};

//person객체를 밀봉하여 프로퍼티 추가,삭제,프로퍼티 어트리뷰트의 재정의를 금지한다
Object.seal(person);

Object.isSealed(person);//true

//밀봉된 객체의 프로퍼티 어트리뷰트 [[Configuralbe]]은 false다
console.log(Object.getOwnPropertyDescriptors(person));

//추가 금지
person.age = 20;//무시됨

//삭제 금지
delete person.name;//무시됨

//프로퍼티의 어트리뷰트가 재정의 불가능한거지 값의 갱신은 [[Writalbe]] true라 가능
person.name = 'Kim';

//프로퍼티 어트리뷰트의 재정의가 금지된다
Object.defineProperty(person,'name',{
    configurable: true
}); //에러발생