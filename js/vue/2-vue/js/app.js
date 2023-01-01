import SearchModel from './models/SearchModel.js';

new Vue({
    el: '#app',
    data: {
        query: '',
        submitted: false,
        searchResult: [],
        tabs: ['추천 검색어', '최근 검색어'],
        selectedTab: '',
        searchResult: []
    },
    created() {
        this.selectedTab=this.tabs[0]
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
        search(){
            SearchModel.list().then(data=>{
                this.submitted = true
                this.searchResult=data
            })
        },
        onChangeTab(e){
            this.selectedTab = e.currentTarget.innerText
        }
    }
})