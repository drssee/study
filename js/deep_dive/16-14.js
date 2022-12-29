//깊은 동결
//재귀적으로 모든 내부 요소에 Object.freeze()

function deepFreeze(target){
    //target이 null이 아니고, target이 객체이고, target이 동결 상태가 아닐때
    if(target && typeof target === 'object' && !Object.isFrozen(target)){
        //동결을 하고
        Object.freeze(target);

        //target의 프로퍼티들을 순회하면서 동결되지 않은 객체를 찾는다
        Object.keys(target).forEach(key=>{
            deepFreeze(target[key]);
        })
    }
    return target;
}

const person = {
    name: 'Lee',
    address: {city: 'Seoul'}
};

//깊은 객체 동결
deepFreeze(person);

//객체안의 객체도 동결
console.log(Object.isFrozen(person.address));//true

//객체안의 객체의 프로퍼티 값 변경 X
person.address.city = 'Busan';
console.log(person);