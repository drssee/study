const data = [
    {
        id: 1,
        name: '[키친르쎌] 홈메이드 칠리소스 포크립 650g',
        // image: 'https://cdn.bmf.kr/_data/product/H1821/5a4ed4e8a6751cb1cc089535c000f331.jpg'
        image: 'https://img-cf.kurly.com/shop/data/goodsview/20201127/gv20000138403_1.jpg'
    },
    {
        id: 2,
        name: '[키친르쎌] 이탈리아 파티 세트 3~4인분',
        // image: 'https://cdn.bmf.kr/_data/product/H503E/300d931e3b8252ed628b6a3c2f56936b.jpg'
        image: 'https://mblogthumb-phinf.pstatic.net/MjAyMTEyMDZfMTQ5/MDAxNjM4NzU4MjMwNTgz.9pJIL0vA2fT41aYxodnbJuGXZXc_87KY9BLwg_R3k7sg.Umm8U0IUXamsWhn6xIGhIH8eHcuLn0Xg_hDjCcd8MIUg.PNG.superkitchen_kr/%EC%8A%88%ED%8D%BC%ED%82%A4%EC%B9%9C_%ED%99%88%ED%8C%8C%ED%8B%B0%EC%84%B8%ED%8A%B8_9.png?type=w800'
    }
]

export default {
    list(query){
        return new Promise(res=>{
            setTimeout(()=>{
                res(data)
            },200);
        })
    },
}
