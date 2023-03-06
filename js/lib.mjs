const pi = Math.PI;

function square(x) {
    return x * x;
}

class Person {
    constructor(name) {
        this.name = name;
    }
}

export { pi,square,Person };

export default x => x * x;