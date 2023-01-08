<template>
  <div>
    <button v-on:click="moveDetail(null)">신규</button>
    <button v-on:click="deleteBlog">삭제</button>
    <table align="center">
      <tr>
        <th>ID</th>
        <th>Name</th>
      </tr>
      <tr v-for="(row, id) in list" :key="id">
        <td>{{ row.id }}</td>
        <td v-on:click="moveDetail(row.id)">{{ row.name }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      list: {},
    };
  },
  mounted() {
    this.getList();
  },

  methods: {
    moveDetail: function (id) {
      if (id != null) {
        this.$emit("moveDetail", id);
      } else {
        this.$emit("moveDetail", null);
      }
    },
    deleteBlog: function () {
      this.$emit("deleteBlog");
    },
    getList: function () {
      this.$axios
        .get(this.$serverUrl + "/sample/list.do", {})
        .then((res) => {
          this.list = res.data; //서버에서 데이터를 목록으로 보내므로 바로 할당하여 사용할 수 있다.
        })
        .catch((err) => {
          if (err.message.indexOf("Network Error") > -1) {
            alert("네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.");
          }
        });
    },
  },
};
</script>

<style></style>
