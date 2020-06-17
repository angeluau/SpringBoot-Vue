<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
                    width="320">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    width="420">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="200">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button type="text" size="small" @click="deleteBook(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                page-size="6"
                :total="total"
                @current-change="page1">
        </el-pagination>

    </div>

</template>

<script>
    export default {
        methods: {
            edit(row) {
                this.$router.push({
                    path: '/update',
                    query:{
                        id:row.id,
                    }
                })

            },
            deleteBook(row) {
                const _this = this;
                axios.delete('http://localhost:8181/book/deleteById/'+row.id).then(function (resp) {


                    _this.$alert('《'+ row.name+'》删除成功', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                            window.location.reload();
                        }
                    });
                    
                })

            },
            page1(currenPage){
                const _this = this;
                axios.get('http://localhost:8181/book/findAll/'+currenPage +'/6').then(function (resp) {
                    _this.tableData = resp.data.content
                    _this.total = resp.data.totalElements

                })
            }
        },
        created(){
            const _this = this;
            axios.get('http://localhost:8181/book/findAll/1/6').then(function (resp) {
                _this.tableData = resp.data.content
                _this.total = resp.data.totalElements

            })
        },

        data() {
            return {
                total:null,
                tableData: null,
            }
        }
    }
</script>