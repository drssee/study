//View.js 모듈을 임포트
import View from './View.js'

const tag = '[FormView]'

//FormView에 View객체 생성
const FormView = Object.create(View);

FormView.setup = function(el){
    this.init(el)
    this.inputEl = el.querySelector('[type=text]')
    this.resetEl = el.querySelector('[type=reset]')
    this.showResetBtn(false)
    this.bindEvents()
    return this
}

FormView.showResetBtn = function(show=true){
    this.resetEl.style.display = show?'block':'none'
}

FormView.onClickReset = function(e){
    //컨트롤러에 위임
    //기존의 이벤트에 커스텀을 해 데이터를 같이 넘긴다
    this.emit('@reset',{input: this.inputEl.value})
    this.showResetBtn(false)
}

FormView.bindEvents = function(){
    //submit 이벤트
    //submit 이벤트 실행시 창이 새로고침 되는데,
    //e.preventDefault()는 submit 이벤트의 기본 동작을 멈춰줌
    this.on('submit',e => e.preventDefault())
    //keyup 이벤트
    this.inputEl.addEventListener('keyup',e=>this.onKeyup(e))
    //click 이벤트
    this.resetEl.addEventListener('click',e=>this.onClickReset(e))
}

FormView.onKeyup = function(e){
    const enter = 13

    this.showResetBtn(this.inputEl.value.length)

    if(!this.inputEl.value.length) this.emit('@reset')
    
    if(e.keyCode !== enter) return
    this.emit('@submit',{input: this.inputEl.value})
}

export default FormView
