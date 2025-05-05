import SwiftUI
import shared

struct ContentView: View {
    @State private var shouldOpenSettings = false

    var body: some View {
        let articleScreen = ArticlesScreen(viewModel: .init())

        NavigationStack {
            articleScreen
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenSettings = true
                        } label: {
                            Label("Settings", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenSettings) {
                            SettingsScreen()
                        }
                    }
                }
        }.refreshable {
            articleScreen.viewModel.articlesViewModel.getArticles(forceRefresh: true)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
       ContentView()
    }
}
