const tag = '[View]'

export default {
    init(el) {
        if(!el) throw el
        this.el = el
        return this
    },
    
    on(event,handler){
        //초기화시 on메서드를 실행하여 el에 이벤트리스너를 등록해둠
        this.el.addEventListener(event,handler)
        return this
    },

    emit(event,data){
        //이벤트에 데이터 추가후 전파
        const evt = new CustomEvent(event, {detail:data})
        this.el.dispatchEvent(evt)
        return this
    },

    hide(){
        this.el.style.display='none'
        return this
    },

    show(){
        this.el.style.display=''
        return this
    }
}