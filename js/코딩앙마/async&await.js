//async
//async가 붙으면 프로미스 객체를 반환
async function getName(){
    // return 'Mike';
    // throw new Error('err');
    return Promise.resolve('Mike');
}

console.log(getName());

getName()
    .then(
        (result)=>{
            console.log(result);
        }
    )
    .catch(
        (error)=>{
            console.log(error);
        }
    )
    .finally(
        ()=>{
            console.log('끝');
        }
    )


//await
//aynsc 키워드가 붙은 함수 내부에서만 사용 가능
function getName2(name){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            resolve(name);
        },1000);
    })
}

async function showName(){
    //await 키워드는 async 또는 promise가 완료될때까지 기다린후 실행
    console.time('X');
    const result = await getName2('Tom');
    console.log(result);
    console.timeEnd('X');
}

showName();

//ex 프로미스 + async,await 예제
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
            success('2번 주문 성공');
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

// async function order(){
//     console.time('order');
//     try{
//         const result1 = await f1();
//         const result2 = await f2(result1);
//         const result3 = await f3(result2);
//         console.log(result3);
//     } catch(error){
//         console.log(error);
//     } finally(){
//         console.timeEnd('order');
//     }
// }
// order();

async function order(){
    console.time('order');
    try{
        const result = await Promise.all([f1(),f2(),f3()]);
        console.log(result);
    } catch(error){
        console.log(error);
    } 
    console.timeEnd('order');
}
order();

