//프로미스
//new Promise((성공,실패)=>{}); //성공,실패 콜백함수
//.then() 프로미스 사용

//Promise 생성자로 생성된 객체는 두가지 프로퍼티를 갖는다 state:pending(대기중),result
//성공(value) => state:fulfilled(이행됨),result:value
//실패(error) => state:rejected(거부됨),result:error

//ex 마트에서 물품구매 성공,실패

//성공
const buy1 = new Promise((resolve,reject)=>{
    setTimeout(function(){
        resolve('구매완료');
    },1000);
});

//실패
// const buy2 = new Promise((resolve,reject)=>{
//     setTimeout(function(){
//         reject(new Error('구매실패'));
//     },1000);
// });

//고객.then(성공함수,실패함수)
// buy1.then(
//     function(result){console.log(result + ' 가지러 가자')},
//     function(error){console.log(error + ' 다시 주문해 주세요')}
// );

// buy2.then(
//     function(result){console.log(result + ' 가지러 가자')},
//     function(error){console.log(error + ' 다시 주문해 주세요')}
// );

//catch문으로 사용하는 것이 더 좋음
// buy1.then(
//     function(result){console.log(result + ' 가지러 가자')}
// ).catch(
//     function(error){console.log(error + ' 다시 주문해 주세요')}
// ).finally(
//     function(){console.log(buy1 + ' --- 주문 끝 ---')}
// );

// buy2.then(
//     function(result){console.log(result + ' 가지러 가자')}
// ).catch(
//     function(error){console.log(error + ' 다시 주문해 주세요')}
// ).finally(
//     function(){console.log(buy2 + ' --- 주문 끝 ---')}
// );

//화살표 함수로 변경
// buy1.then(result => {
//     console.log(result);
// }).catch(error => {
//     console.log(error);
// }).finally(()=>{
//     console.log('끝');
// });

//ex 프로미스 사용해 1,2,3번 주문 완료 순차 호출, 프로미스객체는 전부 성공 반환한다고 가정
//성공(value) => state:fulfilled(이행됨),result:value
const f1 = ()=>{
    return new Promise((success,fail)=>{
        setTimeout(()=>{
            success('1번 주문 완료');
        },1000);    
    })
};

const f2 = (message)=>{
    console.log(message);
    return new Promise((success,fail)=>{
        setTimeout(()=>{
            fail('2번 주문 실패');
        },1000); 
    })
};

const f3 = (message)=>{
    console.log(message);
    return new Promise((success,fail)=>{
        setTimeout(()=>{
            success('3번 주문 완료');
        },1000);
    })
};

console.log('시작');
//f1,f2,f3 함수의 리턴값은 프로미스

//프로미스 체이닝
// f1().then((value)=>f2(value)).then((value)=>f3(value)).then((value)=>console.log(value))
//     .catch(console.log)
//     .finally(()=>{console.log('끝')})

//Promise.all(다 보여주거나,다 보여주지 않거나)
//프로미스 동시 실행(한꺼번에 사용하고 모두 끝나면 value 사용 가능)
// console.time('x')
// Promise.all([f1(),f2(),f3()])
//     .then(
//         (result)=>{
//             console.log(result);
//             console.timeEnd('x');
//         }
//     );

//Promise.race(가장먼저 완료되는 프로미스의 value 사용)
//여러 이미지 로딩시 가장먼저 로딩되는 이미지부터 보여주고 싶을때
console.time('x')
Promise.race([f1(),f2(),f3()])
    .then(
        (result)=>{
            console.log(result);
            console.timeEnd('x');
        }
    );