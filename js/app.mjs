import { pi as PI,square as sq,Person as p} from './lib.mjs';

console.log(PI);
console.log(window.pi,'undefined 모듈내의 변수는 var이어도 독자적인 스코프를 가져서 window객체에 종속되지 않음');
console.log(window.PI,'undefined 모듈내의 변수는 var이어도 독자적인 스코프를 가져서 window객체에 종속되지 않음');
console.log(sq(10));
console.log(new p('Lee'));

import anyName from './lib.mjs'

console.log(anyName(10));
