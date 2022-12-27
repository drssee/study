const person = {
    //일반적인 데이터 프로퍼티
    firstName: 'Ungmo',
    lastName: 'Lee',

    //fullName은 접근자 함수로 구성된 접근자 프로퍼티
    get fullName(){
        return `${this.firstName} ${this.lastName}`;
    },

    set fullName(name){
        [this.firstName,this.lastName] = name.split(' ');
    }
};

//getter
console.log(person.fullName);

//setter
person.fullName = 'Heegun Lee';

//getter
console.log(person.fullName);

//데이터프로퍼티와 접근자프로퍼티의 프로퍼티어트리뷰트
let dataPD = Object.getOwnPropertyDescriptors(person);
console.log(dataPD);

console.log(Object.getOwnPropertyDescriptor(person,'fullName'));