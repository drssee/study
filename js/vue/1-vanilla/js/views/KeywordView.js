import View from '../views/View.js'

const tag = '[KeywordView]'

const KeywordView = Object.create(View)

KeywordView.setup = function(el){
    this.init(el)
    return this
}

KeywordView.render = function(data=[]){
    this.el.innerHTML = data.length ? this.getKeywordsHtml(data):'추천 검색어가 없습니다'
    //DOM이 만들어진 뒤에 이벤트 바인딩
    this.bindClick()
    this.show()
}

KeywordView.getKeywordsHtml = function(data){
    return data.reduce((html,item,index)=>{
        html += `<li data-keyword="${item.keyword}">
            <span class="number">${index+1}</span>
            ${item.keyword}
        <li>`
        return html
    },'<ul class="list">')+'</ul>'
}

KeywordView.bindClick = function(){
    Array.from(this.el.querySelectorAll('li')).forEach(li=>{
        li.addEventListener('click',e=>this.onClickKeyword(e))
    })
}

KeywordView.onClickKeyword = function(e){
    //할당구조분해
    //dataset은 data- 사용
    const {keyword} = e.currentTarget.dataset
    this.emit('@click',{keyword})
}

export default KeywordView 