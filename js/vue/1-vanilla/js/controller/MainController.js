//View
import FormView from '../views/FormView.js'
import ResultView from '../views/ResultView.js'
import TabView from '../views/TabView.js'
import KeywordView  from '../views/KeywordView.js'
import HistoryView from '../views/HistoryView.js'
//Model
import SearchModel from '../models/SearchModel.js'
import KeywordModel from '../models/KeywordModel.js'
import HistoryModel from '../models/HistoryModel.js'

const tag = '[MainController]'

export default {
    init(){
        //setup에 return this를 해서 메소드체인 가능

        //폼
        FormView.setup(document.querySelector('form'))
            .on('@submit',e=>this.onSubmit(e.detail.input))
            .on('@reset',e=>this.onResetForm())
        
        //탭
        TabView.setup(document.querySelector('#tabs'))
            .on('@change',e=>this.onChangeTab(e.detail.tabName))//커스텀 이벤트 객체 custumevent(event,{detail:value})

        //결과창
        ResultView.setup(document.querySelector('#search-result'))

        //추천검색어
        KeywordView.setup(document.querySelector('#search-keyword'))
            .on('@click',e=>this.onClickKeyword(e.detail.keyword))

        //검색기록
        HistoryView.setup(document.querySelector('#search-history'))
            .on('@click',e=>this.onClickHistory(e.detail.keyword))
            .on('@remove',e=>this.onRemoveHistory(e.detail.keyword))

        //필요 변수 초기화
        this.selectedTab = '추천 검색어'
        this.renderView()      
    },

    renderView(){
        console.log(tag, 'renderView()')

        HistoryView.hide()
        KeywordView.hide()
        ResultView.hide()

        TabView.setActiveTab(this.selectedTab)

        if(this.selectedTab==='추천 검색어'){
            this.fetchSearchKeyword()
        } else {
            this.fetchSearchHistory()
        }
    },

    fetchSearchKeyword(){
        KeywordModel.list().then(data=>{
            KeywordView.render(data)
        })
    },

    fetchSearchHistory(){
        HistoryModel.list().then(data=>{
            HistoryView.render(data)
        })
    },

    onSubmit(input){
        console.log(tag,'onSubmit()',input)
        //검색 요청
        this.search(input)
    },

    onResetForm(){
        console.log(tag,'onResetForm()')
        //reset 누르면 검색결과가 사라져야함
        ResultView.deleteSearchResultHtml()
        // ResultView.hide() // View에 만들어둔 메서드
        this.renderView()
    },

    search(query){
        console.log(tag,'search()',query)
        //검색 히스토리 저장
        HistoryModel.add(query)
        //검색결과 호출
        SearchModel.list(query).then(data=>{
            this.onSearchResult(data,query)
        })    
    },

    onSearchResult(data,keyword){
        //검색결과를 받아 렌더링
        
        TabView.hide()
        KeywordView.hide()
        HistoryView.hide()
        ResultView.hide()

        FormView.setKeyword(keyword)
        ResultView.render(data)
    },

    onChangeTab(tabName) {
        this.selectedTab = tabName
        this.renderView()
    },

    onClickKeyword(keyword){
        this.search(keyword)
    },

    onClickHistory(history){
        this.search(history)
    },

    onRemoveHistory(history){
        HistoryModel.remove(history)
        this.renderView()
    }
}