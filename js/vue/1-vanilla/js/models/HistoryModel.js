export default {
    data: [
        {keyword:'검색기록2',date:'12.03'},
        {keyword:'검색기록1',date:'12.02'},
        {keyword:'검색기록0',date:'12.01'},
    ],

    list(){
        //비동기를 위한 프로미스패턴
        return Promise.resolve(this.data)
    },

    add(keyword=''){
        keyword=keyword.trim()
        if(!keyword) return
        //중복확인
        if(this.data.some(item=>item.keyword===keyword)){
            this.remove(keyword)
        }

        const date='12.31'
        //기존의 데이터 맨앞에 추가
        this.data=[{keyword,date},...this.data]
    },

    remove(keyword){
        console.log('HistoryModel.remove()')
        //매개변수 keyword와 일치하는 item은 필터링
        this.data=this.data.filter(item=>item.keyword!==keyword)
    }
}