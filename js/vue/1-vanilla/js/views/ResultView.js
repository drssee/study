import View from "./View.js";

const tag = '[ResultView]'

const ResultView = Object.create(View);

ResultView.setup = function(el){
    //resultview를 구동할때 view의 init메소드 사용
    this.init(el)
}

ResultView.render = function(data=[]){
    console.log(tag,'render()',data)
    this.el.innerHTML = data.length ? this.getSearchResultHtml(data) : '검색 결과가 없습니다'
}

ResultView.getSearchResultHtml = function(data){
    return data.reduce((html,item)=>{
        html += this.getSearchItemHtml(item)
        return html;
    },'<ul>') + '</ul>'
},

ResultView.getSearchItemHtml = function(item){
    return `</li>
        <img src= "${item.image}">
        <p>${item.name}</p>
    </li>`
},

ResultView.deleteSearchResultHtml = function(){
    this.el.innerHTML = ''
}

export default ResultView