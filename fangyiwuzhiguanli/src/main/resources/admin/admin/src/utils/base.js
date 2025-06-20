const base = {
    get() {
        return {
            url : "http://localhost:8080/fangyiwuzhiguanli/",
            name: "fangyiwuzhiguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/fangyiwuzhiguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "防疫物资管理信息系统"
        } 
    }
}
export default base
