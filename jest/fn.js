const fn = {
    add : (num1, num2) => {
        return num1 + num2
    },
    makeUser : (name, age, gender) => {
        return { name, age ,gender };
    },
    throwError : () => {
        throw new Error('고의 에러');
    },
    getName : (callback) => {
        const name = 'Mike';다
        setTimeout(() => {
            callback(name);
        }, 3000);
    },
    getAge : (gubun) => {
        const age = 30;
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                if (gubun === '성공') {
                    resolve(age);
                } else if (gubun === '실패') {
                    //일반적으로 reject는 예외가 터지면 자동으로 호출되지 않네?
                    // throw new Error('고의 에러');
                    reject(new Error('고의 에러'));
                }
            }, 3000);
        });
    },
    connectUserDb: () => {
        return new Promise((res) => {
            setTimeout(() => {
                res({
                    name: 'Mike',
                    age: 30,
                    gender: 'male'
                })
            }, 500);
        })
    },
    disconnectUserDb: () => {
        return new Promise((res) => {
            setTimeout(() => {
                res();
            }, 500);
        });
    },
    connectCarDb: () => {
        return new Promise((res) => {
            setTimeout(() => {
                res({
                    brand: 'bmw',
                    name: 'z4',
                    color: 'red'
                })
            }, 500);
        })
    },
    disconnectCarDb: () => {
        return new Promise((res) => {
            setTimeout(() => {
                res();
            }, 500);
        });
    }
}

module.exports = fn;