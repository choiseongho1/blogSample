<template>
  <div align="center">
    <table v-if="propsData == null">
      <tr>
        <td colspan="2">
          <button v-on:click="moveList">목록</button>
        </td>
      </tr>
      <tr>
        <td>Name</td>
        <td><input type="text" v-model="name" /></td>
      </tr>
      <tr>
        <td colspan="2">
          <button v-on:click="fnSave">저장</button>
        </td>
      </tr>
    </table>

    <table v-else>
      <tr>
        <td colspan="2">
          <button v-on:click="moveList">목록</button>
        </td>
      </tr>
      <tr>
        <td>Name</td>
        <td>{{ name }}</td>
      </tr>
      <tr>
        <td colspan="2">
          <button>수정</button>
          <button v-on:click="fnDelete(propsData)">삭제</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  props: {
    propsData: String,
  },
  date() {
    return {
      id: "",
      name: "",
    };
  },
  mounted() {
    if (this.propsData != null) {
      this.fnView(this.propsData);
    }
  },
  methods: {
    moveList: function () {
      this.$emit("moveList");
    },
    fnSave: function () {
      let apiUrl = this.$serverUrl + "/sample";
      this.form = {
        id: this.id,
        name: this.name,
      };

      this.$axios
        .post(apiUrl, this.form)
        .then(() => {
          alert("글이 저장되었습니다.");
          this.$emit("moveList");
        })
        .catch((err) => {
          if (err.message.indexOf("Network Error") > -1) {
            alert("네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.");
          }
        });
    },
    fnView: function (id) {
      this.$axios
        .get(this.$serverUrl + "/sample/" + id, {})
        .then((res) => {
          this.id = res.data.id;
          this.name = res.data.name;
        })
        .catch((err) => {
          if (err.message.indexOf("Network Error") > -1) {
            alert("네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.");
          }
        });
    },
    fnDelete: function (id) {
      this.$axios
        .delete(this.$serverUrl + "/sample/" + id, {})
        .then(() => {
          alert("삭제 완료");
          this.$emit("moveList");
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
