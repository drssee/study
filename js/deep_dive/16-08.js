const person ={};

//데이터 프로퍼티 정의

//person의 firstName프로퍼티를 정의하고
//프로퍼티의 어트리뷰트도 정의
Object.defineProperty(person,'firstName',{
    value: 'Ungmo',
    writable: true,
    enumerable: true,
    configurable: true
});

Object.defineProperty(person,'lastName',{
    value: 'Lee'
    //프로퍼티 어트리뷰트는 초기값으로 들어감
    //false,false,false
});

let descriptor = Object.getOwnPropertyDescriptor(person, 'firstName');
console.log('firstName = ',descriptor);

descriptor = Object.getOwnPropertyDescriptor(person,'lastName');
console.log('lastName = ',descriptor);

//[[Enumerable]]이 false인 경우
//해당 프로퍼티는 for...in문이나 Object.keys 등으로 열거할 수 없다.
//lastName 프로퍼티 어트리뷰트인 [[Enumerable]]은 false
console.log(Object.keys(person));
for(let key in person){
    console.log(key);
}

//[[Writable]]이 false인 경우
//값이 변경되지 않고 무시됨
person.lastName = 'Kim';
console.log(person.lastName);

//[[Configurable]]의 값이 false인 경우 해당 프로퍼티를
//변경(재정의) 및 삭제 할 수 없다
try{
    Object.defineProperty(person,'lastName',{
        enumerable: true
    });
} catch(e){
    console.log(e);
}

descriptor = Object.getOwnPropertyDescriptor(person,'lastName');
console.log('lastName',descriptor); //enumerable 값이 변하지 않았음


//접근자 프로퍼티 정의

//person의 fullName프로퍼티를 정의하고
//프로퍼티 어트리뷰트에 getter setter를 정의
Object.defineProperty(person,'fullName',{
    get(){
        return `${this.firstName} ${this.lastName}`;
    },
    set(name){
        //문자열을 배열로 변환
        [this.firstName,this.lastName] = name.split(' ');
    },
    enumerable: true,
    configurable: true
});
//getter
console.log(person.fullName);
//setter
person.fullName = 'Heegun Lee';
console.log(person.fullName);

//정의한 프로퍼티 어트리뷰트를 보려면 descriptor객체를 생성해야함
descriptor = Object.getOwnPropertyDescriptor(person,'fullName');
console.log('fullName',descriptor);

const person2 = {};

//defineProperties를 이용해 한번에 정의
Object.defineProperties(person2,{
    //데이터 프로퍼티 정의
    firstName: {
        value: 'Ungmo',
        writable: true,
        enumerable: true,
        configurable: true
    },
    lastName: {
        value: 'Lee',
        writable: true,
        enumerable: true,
        configurable: true
    },
    //접근자 프로퍼티 정의
    fullName: {
        get(){
            return `${this.firstName} ${this.lastName}`
        },
        setter(name){
            [this.firstName,this.lastName] = name.split(' ');
        },
        enumerable: true,
        configurable: true
    }
});
let descriptors = Object.getOwnPropertyDescriptors(person2);
console.log(descriptors);



