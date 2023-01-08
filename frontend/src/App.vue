<template>
  <BlogHeader></BlogHeader>

  <!-- 컴포넌트가 목록 조회 인 경우 -->
  <div v-if="doAction === 'list'">
    <BlogList v-on:moveDetail="moveDetail"></BlogList>
  </div>

  <!-- 컴포넌트가 작성인 경우 -->
  <div v-if="doAction === 'detail'">
    <BlogDetail v-on:moveList="moveList" v-bind:propsData="id"></BlogDetail>
  </div>

  <BlogFooter></BlogFooter>
</template>

<script>
import BlogHeader from "./components/BlogHeader.vue";
import BlogList from "./components/BlogList.vue";
import BlogDetail from "./components/BlogDetail.vue";
import BlogFooter from "./components/BlogFooter.vue";

export default {
  name: "App",
  components: {
    BlogHeader: BlogHeader,
    BlogList: BlogList,
    BlogDetail: BlogDetail,
    BlogFooter: BlogFooter,
  },
  methods: {
    moveDetail: function (id) {
      this.id = id;
      this.doAction = "detail";
    },
    moveList: function () {
      this.doAction = "list";
    },
  },

  data: function () {
    return {
      doAction: "list",
      status: "",
      id: "",
    };
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
