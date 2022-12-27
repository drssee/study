//Array
//push() pop() <-뒤에서부터
//unshift() shift() <-앞에서부터

//arr.splice(n,m) , n부터 m개 삭제 vs arr.slice(n,m) , from ~ to 반환
let arr = [1,2,3,4,5];
console.log('삭제된 것 '+arr.splice(1,2));
console.log(arr);

//arr.splice(n,m,...x) , n부터 m개 삭제후 x추가
let arr2 = [1,2,3,4,5];
console.log('삭제된 것 '+arr2.splice(1,2,'x','x'));
console.log(arr2);

//arr.splice 활용
let arr3 = [1,2,3,4,5];
//arr3의 2번째 인덱스 뒤에 55 57 58 추가하고 싶음
console.log('삭제된 것 '+arr3.splice(2,0,55,57,58));
console.log(arr3);

//arr.concat(...arr2) , arr배열과 arr2배열을 병합한 새로운 배열을 반환
let arr4 = [1,2];
let arr5 = [3,4];
let concatResult = arr4.concat(arr5);
console.log(concatResult);

//arr.forEach(요소,인덱스)
let arr6 = ["Mike","Tom","Jane"];
arr6.forEach((i,index)=>{console.log(i,index)});

//arr.includes() , return boolean

//arr.find() , 찾으면 바로 리턴 + 복잡한 조건 vs arr.filter() 전부다 필터링 + 복잡한 조건
let arr7 = [1,2,3,4,5];
console.log(arr7.find(item=>{return item%2===0&&item>2}));

//ex 미성년자를 찾아라
let userList = [
    {name:"Mike",age:30},
    {name:"Jane",age:27},
    {name:"Tom",age:10}
];

//arr.find()
console.log(userList.find((item,index)=>{
    if(item.age<20){
        console.log(`${item.name}은 미성년자 입니다 (${item.age}) ${index}`);
        return item;
    }
}));

//arr.filter()
console.log(userList.filter((item,index)=>{
    if(item.age<20){
        console.log(`${item.name}은 미성년자 입니다 (${item.age}) ${index}`);
        return item;
    }
}));

//arr.reverse()

//arr.map() Java의 map과 같음
//ex2 미성년자 체크한 프로퍼티
//기존 객체 변경하는법
let userList_updated = userList.map(item=>{
    item.isAdult = item.age>20;
});
console.log(userList);

//새 객체로 할당하는법
let newUserList = userList.map(item=>{
    return Object.assign({},item,{
        isAdult : item.age>20
    })
});
console.log(newUserList);
//새로할당한 객체와 비교
console.log(userList===newUserList);


//join(배열->문자열),split(문자열->배열)
//join
let arr8 = [1,2,3,4,5];
let joinResult = arr8.join('-');//기본값 ','
console.log(joinResult);

let splitResult = joinResult.split('-')//기본값 ','
console.log(splitResult,'기존 arr8과는 다른 배열',arr8===splitResult);

//cf ''이면 각각문자 요소로
console.log(joinResult.split(''));

//array.isArray()

//sort
let arr9 = [1,5,4,2,3];
arr9.sort()
console.log(arr9);

//sort의 한계점(문자열을 기준으로 정렬을 함)
let arr10 = [27,8,5,13];
arr10.sort();
console.log(arr10);

//해결법(정렬기준 제공)
arr10.sort((a,b)=>{
    console.log(a,b);
    return a-b;
});
console.log(arr10);

//reduce(누적계산값,현재값,초기값)

//ex arr11 모든 요소의 합
let arr11 = [1,2,3,4,5];
//reduce 사용 안할때
var sum=0;
for(let i=0;i<arr11.length;i++){
    sum+=arr11[i];
}
console.log(sum);

//reduce 사용
sum = arr11.reduce((acc,cur)=>{
    return acc+cur;
},0)
console.log(sum);

//ex userList의 모든 유저 나이의 합 구하기
// let userList = [
//     {name:"Mike",age:30},
//     {name:"Jane",age:27},
//     {name:"Tom",age:10}
// ];
const ageSum = userList.reduce((acc,cur)=>{
    return acc+cur.age;
},0);
console.log(ageSum);

//ex userList의 모든 성인유저 이름 추출
const adultUser = userList.reduce((acc,cur)=>{ //초기값을 배열로 만들었으니 acc는 배열
    if(cur.age>20){
        acc.push(cur.name);
    }
    return acc;
},[]);
console.log(adultUser);