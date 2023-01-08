import KeywordView from "./KeywordView.js";

const tage = '[HistoryView]'

const HistoryView = Object.create(KeywordView)

HistoryView.setup = function(el){
    this.init(el)
    this.bindClick()
    return this
}

HistoryView.getKeywordsHtml = function(data=[]){
    return data.reduce((html,item)=>{
        html += `<li data-keyword="${item.keyword}">
            ${item.keyword}
            <span class="date">${item.date}</span>
            <button class="btn-remove"></button>
        </li>`
        return html
    },'<ul class="list">')+'</ul>'
}

HistoryView.bindClick = function(){
    Array.from(this.el.querySelectorAll('.btn-remove')).forEach(button=>{
        button.addEventListener('click',e=>this.onClick(e))
    })
}

HistoryView.onClick = function(e){
    e.stopPropagation()
    //e.currentTarget.parentElement.dataset.keyword
    const {keyword} = e.currentTarget.closest('li').dataset
    this.emit('@remove',{keyword})
}

export default HistoryView