import SearchModel from './models/SearchModel.js';
import KeywordModel from './models/keywordModel.js';
import HistoryModel from './models/HistoryModel.js';

new Vue({
    el: '#app',
    data: {
        query: '',
        submitted: false,
        searchResult: [],
        tabs: ['추천 검색어', '최근 검색어'],
        selectedTab: '',
        keywords: [],
        history: [],
        searchResult: []
    },
    created() {
        this.selectedTab=this.tabs[0]
        this.fetchKeywords()
        this.fetchHistory()
    },
    methods: {
        onSubmit(e){
            this.search()
        },
        onKeyUp(e){
            if(!this.query.length) this.resetForm()
        },
        onReset(e){
            this.resetForm()
        },
        resetForm(){
            //입력폼 value 초기화
            this.query=''
            //submit 여부 초기화
            this.submitted=false
            //검색결과 초기화
            this.searchResult=[]
        },
        fetchKeywords(){
            KeywordModel.list().then(data=>{
                this.keywords = data
            })
        },
        fetchHistory(){
            HistoryModel.list().then(data=>{
                this.history = data
            })
        },
        onClickKeyword(keyword){
            this.query = keyword
            this.search()
        },
        onClickRemoveHistory(keyword){
            //stopPropagation(), 이벤트 전파 방지
            HistoryModel.remove(keyword)
            this.fetchHistory()
        },
        search(){
            SearchModel.list().then(data=>{
                this.submitted = true
                this.searchResult=data
            })
            HistoryModel.add(this.query)
            this.fetchHistory()
        },
        onChangeTab(e){
            this.selectedTab = e.currentTarget.innerText
        }
    }
})