//View
import FormView from '../views/FormView.js'
import ResultView from '../views/ResultView.js'
import TabView from '../views/TabView.js'
//Model
import SearchModel from '../models/SearchModel.js'
import KeywordModel from '../models/KeywordModel.js'
import HistoryModel from '../models/HistoryModel.js'

const tag = '[MainController]'

export default {
    init(){
        //setup에 return this를 해서 메소드체인 가능
        FormView.setup(document.querySelector('form'))
            .on('@submit',e=>this.onSubmit(e.detail.input))
            .on('@reset',e=>this.onResetForm())

        ResultView.setup(document.querySelector('#search-result'))

        TabView.setup(document.querySelector('#tabs'))
            .on('@change',e=>this.onChangeTab(e.detail.tabName))//

        this.selectedTab = '추천 검색어'
        this.renderView()      
    },

    renderView(){
        console.log(tag, 'renderView()')
        TabView.setActiveTab(this.selectedTab)
        ResultView.hide()
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
    },

    search(query){
        console.log(tag,'search()',query)
        //검색결과 호출
        SearchModel.list(query).then(data=>{
            this.onSearchResult(data)
        })    
    },

    onSearchResult(data){
        //검색결과를 받아 렌더링
        ResultView.render(data)
    },

    onChangeTab(tabName) {
        debugger
    }
}