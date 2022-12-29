//일반 객체의 __proto__는 접근자 프로퍼티다
Object.getOwnPropertyDescriptor(Object.prototype,'__proto__');

//함수 객체의 prototype은 데이터 프로퍼티다
Object.getOwnPropertyDescriptor(function(){});